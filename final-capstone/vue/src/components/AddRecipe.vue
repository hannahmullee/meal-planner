<template>
  <div class="add-recipe">
    <div class="content">
      <h1>Add a Recipe</h1>
    </div>
    <main-nav />&nbsp;&nbsp; <br />
    <br />
    <br />
    <br />
    <form class="form" v-on:submit.prevent="saveRecipe">
      <label for="recipe-name">Recipe Name:</label>
      <input class="recipe-name" v-model="recipe.title" id="recipe-name" />
      <br />
      <br />
      <label for="ingredients">Ingredients:</label>
      <textarea
        class="ingredients"
        id="ingredients"
        name="ingredients"
        rows="4"
        cols="50"
        v-model="recipe.ingredients"
      >
      </textarea>
      <br />
      <br />
      <label for="instructions">Instructions:</label>
      <textarea
        class="instructions"
        id="instructions"
        name="instructions"
        rows="4"
        cols="50"
        v-model="recipe.instructions"
      >
      </textarea>
      <br />
      <br />
      <button class="AddRecipeSubmit">Submit</button>
    </form>
  </div>
</template>

<script>
import RecipeService from "../services/RecipeService";
import MainNav from "./MainNav.vue";

export default {
  components: { MainNav },
  data() {
    return {
      recipe: {
        title: "",
        category: "",
        instructions: "",
        ingredients: "",
        userId: this.$store.state.user.id,
      },
    };
  },
  methods: {
    saveRecipe() {
      console.log("saving recipe");
      console.log(this.recipe.title);
      RecipeService.createRecipe(this.recipe).then((response) => {
        if (response.status === 201) {
          console.log("recipe created!");
          alert("Your recipe has been added!");
        }
      });
      this.recipe = {};
    },
  },
};
</script>

<style>
.AddRecipeSubmit {
  font-size: 3vh;
}
.recipe-name {
  font-size: 3vh;
}
.category-name {
  font-size: 3vh;
}
.ingredients {
  font-size: 3vh;
}
.instructions {
  font-size: 3vh;
}
.form {
  display: flex;
  flex-direction: column;
  font-family: Raleway, Verdana, Geneva, Tahoma, sans-serif;
  font-size: 3vh;
  border: double black 6px;
  background-color: #dee2e4;
  padding: 25px;
  width: 1000px;
  margin-right: auto;
  margin-left: auto;
}
.add-recipe {
  text-align: center;
  padding: 1vh;
  margin: 40px;
  box-shadow: 8px 8px 8px rgba(68, 68, 68, 0.6);
  background-color: rgb(148, 148, 148);
}
.add-recipe .content {
  box-shadow: 0px 10px 10px rgba(68, 68, 68, 0.363);
  position: relative;
  padding: 1vh;
  background-color: #ddd;
  background-image: url("~@/pictures/background1.jpeg");
  background-repeat: no-repeat;
  background-size: cover;
}

.AddRecipeSubmit {
  border: .5px black solid;
  font-family: Raleway;
  font-weight: bold;
  display: flex;
  width: 200px;
  height: 50px;
  font-size: 2vh;
  justify-content: center;
  align-items: center;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  margin-left: 41%;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
}
</style>