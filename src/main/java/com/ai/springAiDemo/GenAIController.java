package com.ai.springAiDemo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GenAIController {

    ChatService chatService;
    ImageService imageService;
    RecipeService recipeService;




    public GenAIController(ChatService chatService,ImageService imageService, RecipeService recipeService) {
        this.chatService = chatService;
        this.imageService = imageService;
        this.recipeService=recipeService;
    }

    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("ask-ai-options")
    public String getResponseOptions(@RequestParam String prompt){
        return chatService.getResponseOptions(prompt);
    }

//    @GetMapping("generate-image")
//    public void getResponse(HttpServletResponse response, @RequestParam String prompt) throws IOException {
//        ImageResponse imageResponse=imageService.generateImage(prompt);
//       String imageUrl= imageResponse.getResult().getOutput().getUrl();
//        response.sendRedirect(imageUrl);
//    }

    @GetMapping("generate-image")
    public List<String> getResponse(HttpServletResponse response, @RequestParam String prompt) throws IOException {
        ImageResponse imageResponse=imageService.generateImage(prompt);
       List<String> imageUrl= imageResponse.getResults().stream()
                        .map(result->result.getOutput().getUrl())
                                .toList();

        return imageUrl;
    }

    @GetMapping("recipe-creator")
    public String recipeCreator(@RequestParam String ingredients,
                                @RequestParam (defaultValue = "any") String cuisine,
                                @RequestParam (defaultValue = "") String deitaryRestrictions
                                ){
        return recipeService.createRecipe(ingredients,cuisine,deitaryRestrictions);

    }




}
