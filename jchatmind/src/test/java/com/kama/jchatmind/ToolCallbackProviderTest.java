package com.kama.jchatmind;

import com.kama.jchatmind.agent.examples.JChatMindV2;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ToolCallbackProviderTest {

    @Autowired
    @Qualifier("deepseek-chat")
//    @Qualifier("glm-4.6")
    private ChatClient chatClient;
    @Resource
    private ToolCallbackProvider toolCallbackProvider;

    @Test
    public void toolCallbackProviderTest() {
        ToolCallback[] toolCallbacks = toolCallbackProvider
                .getToolCallbacks();

        JChatMindV2 agent = new JChatMindV2(
                "test-agent-v2",
                "测试 Agent V2",
                "你是一个智能助手，可以帮助用户查询天气、日期和城市信息。",
                chatClient,
                20,
                "test-session-v2",
                Arrays.asList(toolCallbacks)
        );

        // 测试需要调用工具的对话
        // 无法处理国际城市
        String userInput = "纽伦堡今天的天气怎么样？上海体育场周围的饭店有哪些";
        String response = agent.chat(userInput);
        /**
         * ========== Tool Calling ==========
         * [ToolCalling #1]
         * - name      : maps_weather
         * - arguments : {"city": "纽伦堡"}
         * =================================

         * ========== Tool Calling ==========
         * [ToolCalling #1]
         * - name      : maps_geo
         * - arguments : {"address": "上海体育场", "city": "上海"}
         * =================================

         * ========== Tool Calling ==========
         * [ToolCalling #1]
         * - name      : maps_around_search
         * - arguments : {"location": "121.473667,31.230525", "keywords": "饭店", "radius": "1000"}
         * =================================

         * 用户输入: 纽伦堡今天的天气怎么样？上海体育场周围的饭店有哪些
         * AI 回复: 关于您的问题：
         *
         * 1. **纽伦堡天气查询**：很抱歉，我尝试查询纽伦堡的天气时遇到了技术问题。天气查询功能可能暂时无法处理国际城市的查询。
         *
         * 2. **上海体育场周围的饭店**：我为您找到了上海体育场周围1公里范围内的多家饭店，包括：
         *
         * - **饭阿伯(天安中心店)** - 南京西路338号天安中心B1层
         * - **1933Rose中餐厅(扬子饭店)** - 汉口路740号扬子精品酒店2层
         * - **国际饭店帆声饼屋** - 黄河路28号
         * - **菜饭骨头煲(威海小区店)** - 威海路62号威海小区
         * - **金饭碗(仙乐斯广场店)** - 南京西路388号仙乐斯广场
         * - **蟹江南·纯蟹黄拌饭(人民广场店)** - 南京西路388号仙乐斯广场
         *
         * 这些饭店涵盖了各种菜系，从传统上海菜到日式丼饭、蟹黄捞饭等，您可以根据自己的口味选择。
         */

        System.out.println("用户输入: " + userInput);
        System.out.println("AI 回复: " + response);
        System.out.println("对话历史长度: " + agent.getConversationHistory().size());

//        // 打印出可用工具名称
//        for (ToolCallback cb : toolCallbacks) {
//            var def = cb.getToolDefinition();
//            System.out.println(def.name() + " -> " + def.description());
//            System.out.println(def.inputSchema());
//        }


        /**
         * maps_regeocode -> 将一个高德经纬度坐标转换为行政区划地址信息
         * {"type":"object","properties":{"location":{"type":"string","description":"经纬度"}},"required":["location"]}
         * maps_geo -> 将详细的结构化地址转换为经纬度坐标。支持对地标性名胜景区、建筑物名称解析为经纬度坐标
         * {"type":"object","properties":{"address":{"type":"string","description":"待解析的结构化地址信息"},"city":{"type":"string","description":"指定查询的城市"}},"required":["address"]}
         * maps_ip_location -> IP 定位根据用户输入的 IP 地址，定位 IP 的所在位置
         * {"type":"object","properties":{"ip":{"type":"string","description":"IP地址"}},"required":["ip"]}
         * maps_weather -> 根据城市名称或者标准adcode查询指定城市的天气
         * {"type":"object","properties":{"city":{"type":"string","description":"城市名称或者adcode"}},"required":["city"]}
         *
         */

    }
}
