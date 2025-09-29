# Copilot Instructions for springAiDemo

## Project Overview
- **Backend:** Java Spring Boot (see `src/main/java/com/ai/springAiDemo/`)
- **Frontend:** React (see `spring-ai-demo-react/`)
- **Purpose:** Exposes AI-powered endpoints for chat, image generation, and recipe creation, consumed by a React UI.

## Architecture & Data Flow
- **REST API Endpoints:**
  - `/ask-ai`, `/ask-ai-options`: Text chat with OpenAI models via `ChatService`.
  - `/generate-image`: Image generation via `ImageService` (OpenAI DALL-E).
  - `/recipe-creator`: Recipe generation using `RecipeService` (OpenAI chat model, prompt templating).
- **Service Layer:** Each AI feature is encapsulated in its own service class. Services use Spring AI abstractions for model calls.
- **Frontend Integration:** React components (`ChatComponent.js`, `ImageGenerator.js`, `RecipeGenerator.js`) call backend endpoints at `localhost:8080`.
- **CORS:** Configured in `WebConfig.java` to allow frontend dev server access.

## Developer Workflows
- **Build Backend:**
  - `./mvnw clean package` (Windows: `mvnw.cmd clean package`)
  - Run: `./mvnw spring-boot:run` (or use your IDE)
- **Build Frontend:**
  - `cd spring-ai-demo-react`
  - `npm install`
  - `npm start` (runs on port 3000)
- **Run Tests:**
  - Backend: `./mvnw test`
  - Frontend: `npm test`

## Key Conventions & Patterns
- **Prompt Engineering:** Prompts for AI models are constructed in service classes, sometimes using `PromptTemplate` for parameterization (see `RecipeService`).
- **Model Selection:** Uses OpenAI GPT-4o for chat, DALL-E for images (see `OpenAiChatOptions`, `OpenAiImageOptions`).
- **Error Handling:** Minimal; errors are logged in frontend, not surfaced to users.
- **API URLs:** Hardcoded to `localhost:8080` in frontend; update if backend port changes.
- **React State:** Each feature has its own stateful component; no global state management.

## Integration & Extensibility
- **Add New AI Features:**
  - Create a new service class in backend, expose via controller, and add a React component.
- **External Dependencies:**
  - Spring AI, OpenAI API (API keys/config required in `application.properties`).
- **CORS:** Update `WebConfig.java` if frontend URL changes.

## References
- Backend entrypoint: `SpringAiDemoApplication.java`
- Main controller: `GenAIController.java`
- Example service: `ChatService.java`, `ImageService.java`, `RecipeService.java`
- React entrypoint: `spring-ai-demo-react/src/index.js`

---
For questions or unclear patterns, review the referenced files or ask for clarification.
