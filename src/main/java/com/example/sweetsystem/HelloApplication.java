package com.example.sweetsystem;
import com.example.sweetsystem.clasess.Client;
import com.example.sweetsystem.clasess.Recipe;
import com.example.sweetsystem.clasess.RecipesList;
import com.example.sweetsystem.clasess.UsersList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    public static Stage stage=null;
   @Override
    public void start(Stage stage) throws IOException {
       Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/sweetsystem/Controllers/Index.fxml")));
        Scene scene=new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        HelloApplication.stage =stage;
        stage.show();
    }

    public static void main(String[] args) {
       preLaunch(); 
       launch();
    }

    private static void preLaunch() {
       makeClients();
       makeOwners();
       makeAdmin();
       makeSupplayer();
    }

    private static void makeSupplayer() {
    }

    private static void makeAdmin() {

    }

    private static void makeOwners() {

    }

    private static void makeClients() {
        Client u1 = new Client("osama", "osama1111222@gmail.com", "1234", "Client", "nablus");
        makeRecipe1(u1);
        Client u2 = new Client("ali", "ali12345@gmail.com", "5678", "Client", "ramallah");
        makeRecipe2(u2);
        Client u3 = new Client("sara", "sara78910@gmail.com", "abcd", "Client", "jerusalem");
        makeRecipe3(u3);

        Client u4 = new Client("ahmed", "ahmed54321@gmail.com", "efgh", "Client", "hebron");
        makeRecipe4(u4);
        Client u5 = new Client("lina", "lina99887@gmail.com", "ijkl", "Client", "jenin");

        UsersList.users.add(u1);
        UsersList.users.add(u2);
        UsersList.users.add(u3);
        UsersList.users.add(u4);
        UsersList.users.add(u5);

    }

    private static void makeRecipe4(Client u4) {


        Recipe r8 = new Recipe("Chocolate Fudge Cake", "C:\\Users\\osama\\Desktop\\SweetManagementSystem\\src\\main\\resources\\com\\example\\sweetsystem\\Images\\cakes\\UserCake8.jpg", "Decadent chocolate fudge cake Ingredients For the Cake:",
                "2 cups all-purpose flour\n" +
                        "1 3/4 cups sugar\n" +
                        "1 cup unsweetened cocoa powder\n" +
                        "1/2 cup chocolate chips\n" +
                        "2 tsp baking soda",
                "Chocolate,Wheat");
        RecipesList.Recipes.add(r8);
        u4.addRecipe(r8);
    }

    private static void makeRecipe3(Client u3) {
        Recipe r6 = new Recipe("Orange Drizzle Cake", "C:\\Users\\osama\\Desktop\\SweetManagementSystem\\src\\main\\resources\\com\\example\\sweetsystem\\Images\\cakes\\UserCake5.jpg", "Moist orange drizzle cake Ingredients For the Cake:",
                "1 3/4 cups all-purpose flour\n" +
                        "1 cup sugar\n" +
                        "1/2 cup orange juice\n" +
                        "1/4 cup unsalted butter\n" +
                        "1 tsp orange zest",
                "Orange,Wheat");

        Recipe r7 = new Recipe("Toffee Nut Brownies", "C:\\Users\\osama\\Desktop\\SweetManagementSystem\\src\\main\\resources\\com\\example\\sweetsystem\\Images\\cakes\\UserCake4.jpg", "Chewy toffee nut brownies Ingredients For the Brownies:",
                "1 cup all-purpose flour\n" +
                        "1 cup sugar\n" +
                        "1/2 cup toffee bits\n" +
                        "1/2 cup chopped nuts\n" +
                        "1/4 cup cocoa powder",
                "Toffee,Nuts,Wheat");

        RecipesList.Recipes.add(r6);
        RecipesList.Recipes.add(r7);

        u3.addRecipe(r6);
        u3.addRecipe(r7);
    }

    private static void makeRecipe2(Client u2) {
        Recipe r4 = new Recipe("Toffee Caramel Cake", "C:\\Users\\osama\\Desktop\\SweetManagementSystem\\src\\main\\resources\\com\\example\\sweetsystem\\Images\\cakes\\UserCake6.jpg", "Rich toffee caramel cake Ingredients For the Cake:",
                "2 cups all-purpose flour\n" +
                        "1 1/2 cups sugar\n" +
                        "1 cup toffee bits\n" +
                        "1/2 cup unsalted butter\n" +
                        "1/2 cup milk",
                "Toffee,Wheat");

        Recipe r5 = new Recipe("Chocolate Orange Tart", "C:\\Users\\osama\\Desktop\\SweetManagementSystem\\src\\main\\resources\\com\\example\\sweetsystem\\Images\\cakes\\UserCake7.jpg", "Zesty chocolate orange tart Ingredients For the Tart:",
                "1 1/2 cups all-purpose flour\n" +
                        "1/4 cup cocoa powder\n" +
                        "1/2 cup sugar\n" +
                        "1/2 cup orange zest\n" +
                        "1/2 cup dark chocolate",
                "Chocolate,Orange,Wheat");

        RecipesList.Recipes.add(r4);
        RecipesList.Recipes.add(r5);


        u2.addRecipe(r4);
        u2.addRecipe(r5);


    }

    private static void makeRecipe1(Client u1) {
        Recipe r1=new Recipe("Creamy chocolate","C:\\Users\\osama\\Desktop\\SweetManagementSystem\\src\\main\\resources\\com\\example\\sweetsystem\\Images\\cakes\\UserCake1.jpg","Creamy chocolate cake" +
                "Ingredients " +
                "For the Cake:","2 cups all-purpose flour\n" +
                "1 3/4 cups sugar\n" +
                "3/4 cup unsweetened cocoa powder\n" +
                "2 tsp baking powder\n" +
                "1 1/2 tsp baking soda","Wheet,Egg");

        Recipe r2 = new Recipe("Vanilla Delight", "C:\\Users\\osama\\Desktop\\SweetManagementSystem\\src\\main\\resources\\com\\example\\sweetsystem\\Images\\cakes\\UserCake2.jpg", "Vanilla cake with a smooth frosting Ingredients For the Cake:",
                "2 cups all-purpose flour\n" +
                        "1 1/2 cups sugar\n" +
                        "1 cup unsalted butter\n" +
                        "1 tsp vanilla extract\n" +
                        "3 large eggs",
                "Egg");

        Recipe r3 = new Recipe("Strawberry Shortcake", "C:\\Users\\osama\\Desktop\\SweetManagementSystem\\src\\main\\resources\\com\\example\\sweetsystem\\Images\\cakes\\UserCake3.jpg", "A light and fluffy strawberry shortcake Ingredients For the Cake:",
                "1 1/2 cups all-purpose flour\n" +
                        "1/2 cup sugar\n" +
                        "1/4 cup vegetable oil\n" +
                        "1/2 cup milk\n" +
                        "1 cup fresh strawberries",
                "Wheat,Water");




        RecipesList.Recipes.add(r1);
        RecipesList.Recipes.add(r2);
        RecipesList.Recipes.add(r3);
        //RecipesList.Recipes.add(r1);

        u1.addRecipe(r1);
        u1.addRecipe(r2);
        u1.addRecipe(r3);
    }
}