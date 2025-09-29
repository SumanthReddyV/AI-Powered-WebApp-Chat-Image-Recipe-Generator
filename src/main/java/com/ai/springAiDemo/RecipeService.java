package com.ai.springAiDemo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {
    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    private final ChatModel chatModel;

    public String createRecipe(String ingredients,
                               String cuisine,
                               String dietaryRestrictions){
        var template = """
                I want to create a receipe using the following ingredients:{ingredients}.
                The cuisine type I prefer is {cuisine}.
                Please consider the following deitary restrictions:{deitaryRestrictions}.
                Please provide me with a detailed reciepe includeing title, list of ingredients, and cooking instructions.
                """;
        PromptTemplate promptTemplate=new PromptTemplate(template);
        Map<String,Object> params=Map .of(
                "ingredients",ingredients,
                "cuisine",cuisine,
                "deitaryRestrictions",dietaryRestrictions

        );

        Prompt prompt= promptTemplate.create(params);
        return chatModel.call(prompt).getResult().getOutput().getText();
    }

}
