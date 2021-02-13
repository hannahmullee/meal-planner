<template>
  <div class="recipe-details">
    <h1>Recipe Details</h1>
    <main-nav />
    <br /><br />
    <button class="save-btn" v-on:click.prevent="saveRecipe()">Save</button>
    <div class="more-recipe-details">
      <div>
        <h2>
          {{ recipe.title }}
          <br />
        </h2>
        <img v-bind:src="recipe.image" />
      </div>
      <br />
      <div
        class="ingredients"
        v-for="ingredient in ingredients"
        v-bind:key="ingredient.name"
      >
        <p class="ingredient">
          {{ ingredient.amount.us.value.toFixed(2) }}
          {{ ingredient.amount.us.unit }} - {{ ingredient.name }}
        </p>
      </div>
      <div id="recipe-instructions"></div>
    </div>
  </div>
</template>

<script>
import apiService from "../services/ApiService";
import MainNav from "./MainNav.vue";
import RecipeService from "../services/RecipeService";

export default {
  components: { MainNav },
  props: {
    searchTerm: String,
    id: Number,
  },
  data() {
    return {
      ingredients: [],
      recipe: {
        userId: this.$store.state.user.id,
      },
      ingredient: {
        userId: Number,
        name: "",
        isOnGroceryList: false,
        recipeId: 0,
        quantity: Number,
        measurement: "",
      },
      ingredientsToSave: [],
    };
  },
  methods: {
    saveRecipe() {
      console.log("saving recipe");
      this.recipe.userId = this.$store.state.user.id;
      console.log(this.recipe.userId);
      RecipeService.createRecipe(this.recipe)
        .then((response) => {
          if (response.status === 201) {
            console.log("recipe created!");
            alert("Your recipe has been added!");
          }
        })
        .then(
          setTimeout(() => {
            RecipeService.getRecipeId(this.recipe.title).then((response) => {
              if (response.status === 200) {
                this.ingredients.forEach((apiIngredient) => {
                  let thisIngredient = {};
                  (thisIngredient.userId = this.$store.state.user.id),
                    (thisIngredient.name = apiIngredient.name),
                    (thisIngredient.isOnGroceryList =
                      apiIngredient.isOnGroceryList),
                    (thisIngredient.recipeId = response.data),
                    (thisIngredient.quantity = Number.parseFloat(
                      apiIngredient.amount.us.value.toFixed(2)
                    )),
                    (thisIngredient.measurement = apiIngredient.amount.us.unit),
                    this.ingredientsToSave.push(thisIngredient);
                  console.log("USER ID: " + this.ingredient.userId);
                });
                RecipeService.saveIngredients(
                  response.data,
                  this.ingredientsToSave
                ).then((response) => {
                  if (response.status === 201) {
                    console.log("Ingredients saved");
                  }
                });
              }
            });
          }, 2000)
        );
    },
    // saveIngredients() {

    // },
  },

  created() {
    console.log("RECIPE ID" + " " + this.$route.params.id);
    apiService.getRecipeInfo(this.$route.params.id).then((response) => {
      if (response.status === 200) {
        console.log(response.data);
        this.recipe = response.data;
        document.getElementById(
          "recipe-instructions"
        ).innerHTML = this.recipe.instructions;
      }
    });
    apiService.getIngredients(this.$route.params.id).then((response) => {
      if (response.status === 200) {
        console.log(response.data);
        this.ingredients = response.data.ingredients;
      }
    });
  },
};
</script>

<style>
.ingredient{
  margin: 1px;
}

#recipe-instructions {
  text-align: left;
  margin-top: 50px;
  margin-bottom: 20px;
}
.recipe-details {
  text-align: center;
}
.ingredients {
  font-size: 2vh;
}

.more-recipe-details {
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

.save-btn {
  display: flex;
  width: 200px;
  height: 50px;
  font-size: 2vh;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  text-align: center;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
  margin-left: auto;
  margin-right: auto;
}
</style>