# AI-Powered-WebApp-Chat-Image-Recipe-Generator

## Features

1. **Chat with AI**: Engage in natural language conversations with the AI model.
2. **Image Generation**: Generate images based on textual descriptions using OpenAI's DALL-E.
3. **Recipe Creation**: Create recipes tailored to user-provided ingredients and dietary preferences.

## Architecture

- **Backend**: Java Spring Boot
  - REST API Endpoints:
    - `/ask-ai`, `/ask-ai-options`: Text chat with OpenAI models via `ChatService`.
    - `/generate-image`: Image generation via `ImageService`.
    - `/recipe-creator`: Recipe generation using `RecipeService`.
  - Service Layer: Encapsulates AI features in dedicated service classes.
  - CORS Configuration: Allows frontend access via `WebConfig.java`.

- **Frontend**: React
  - Components:
    - `ChatComponent.js`: Handles chat interactions.
    - `ImageGenerator.js`: Manages image generation requests.
    - `RecipeGenerator.js`: Facilitates recipe creation.
  - State Management: Local state within components.

## Setup Instructions

### Backend
1. Navigate to the project root directory.
2. Build the backend:
   ```bash
   ./mvnw clean package
   ```
3. Run the backend:
   ```bash
   ./mvnw spring-boot:run
   ```

### Frontend
1. Navigate to the React frontend directory:
   ```bash
   cd spring-ai-demo-react
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm start
   ```

## Testing

- **Backend Tests**:
  ```bash
  ./mvnw test
  ```
- **Frontend Tests**:
  ```bash
  npm test
  ```

## Configuration

- Update `application.properties` for backend configurations.
- Ensure the OpenAI API key is set in the environment variables.

## References

- Backend entrypoint: `SpringAiDemoApplication.java`
- Main controller: `GenAIController.java`
- Example services: `ChatService.java`, `ImageService.java`, `RecipeService.java`
- React entrypoint: `spring-ai-demo-react/src/index.js`

## Contribution

Feel free to fork this repository and submit pull requests for new features or bug fixes.
