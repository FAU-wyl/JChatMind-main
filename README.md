# AI Agent Assistant - JChatMind

JChatMind is an intelligent AI Agent system built on Spring AI. It implements a full Think-Execute loop with tool calling and RAG-based knowledge retrieval, enabling multi-step task completion beyond a simple chat interface.

This project focuses on:
- Autonomous planning and execution (Think-Execute loop)
- Tool orchestration with extensible registration
- RAG pipeline with vector search (pgvector)
- Multi-model support via a registry pattern
- Real-time status streaming to the UI via SSE

## Demo

![Demo 1](https://file1.kamacoder.com/i/web/2026-01-09_16-30-36.jpg)
![Demo 2](https://file1.kamacoder.com/i/web/2026-01-09_16-31-19.jpg)
![Demo 3](https://file1.kamacoder.com/i/web/2026-01-09_16-31-49.jpg)
![Demo 4](https://file1.kamacoder.com/i/web/2026-01-09_16-32-08.jpg)


## Key Features

1. **True Agent Loop (Think-Execute + State Machine)**
   - Multi-round planning and tool execution
   - State management (THINKING / EXECUTING / DONE / ERROR)
   - Error handling and maximum step control to prevent infinite loops

2. **Tool System (Fixed + Optional Tools, Extensible and Governable)**
   - Automatic tool registration
   - Fixed vs. optional tool management
   - Extend tools without modifying the core flow
   - Manual control of tool calling workflow instead of auto-execution

3. **RAG Knowledge Base (PostgreSQL + pgvector)**
   - Markdown parsing and chunking
   - Embedding generation and storage
   - Vector similarity search with ivfflat indexing
   - One PostgreSQL stack for structured + vector data

4. **Multi-Model Support (ChatClientRegistry Pattern)**
   - Switch between DeepSeek, Zhipu AI, and more
   - Unified ChatClient interface
   - Registry pattern for decoupled creation and usage

5. **SSE Real-Time Streaming**
   - Live status updates to the frontend
   - Transparent execution progress for users
   - Simpler than WebSocket for one-way streaming

## What You Will Get

- Agent loop design: multi-step planning, tool invocation, and state control
- Tool framework design: registration, scheduling, error handling
- Full RAG pipeline: parsing, chunking, embeddings, and vector search
- Multi-model architecture with a registry pattern
- SSE-based real-time updates and connection management
- Backend engineering: Spring Boot layering, REST APIs, MyBatis SQL, vector TypeHandlers

