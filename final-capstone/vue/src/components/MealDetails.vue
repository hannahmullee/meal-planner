<template>
  <div class="mealDetailsContainer">
    <div class="content">
      <h1 class="mealDetailsTitle">Meal Details</h1>
    </div>
    <main-nav />
    <h2 class="mealName">{{ meal.name }}</h2>

    <div class="recipeCardContainer">
      <div v-for="recipe in recipes" :key="recipe.recipeId" class="recipeCard">
        <h3 class="recipeTitle">{{ recipe.title }}</h3>
        <router-link
          :to="{ name: 'recipeDetails', params: { id: recipe.recipeId } }"
          >View Recipe Details</router-link
        >
        <button
          class="deleteRecipeInMeal"
          v-on:click="deleteRecipeFromMeal(recipe.recipeId)"
        >
          Delete Recipe
        </button>
      </div>
    </div>
    <button
      class="addRecipeBtn"
      v-on:click="getRecipes(), (showForm = true)"
      v-show="showForm === false"
    >
      Add A Recipe
    </button>
    <form class="addNewRecipeForm" v-show="showForm === true">
      <div v-for="recipe in allMyRecipes" :key="recipe.recipeId" class="recipes">
        <input
          type="checkbox"
          v-model="recipeToSave.checkedRecipes"
          v-bind:value="recipe.recipeId"
        />
        <label> {{ recipe.title }} </label>
      </div>
      <button class="addBtn" v-on:click="addNewRecipe()">Add</button>
    </form>
  </div>
</template>

<script>
import MainNav from "./MainNav.vue";
import mealService from "../services/MealService";
import recipeService from "../services/RecipeService";

export default {
  components: { MainNav },
  data() {
    return {
      meal: {},
      recipes: [],
      recipesIdsInMeal: [],
      allMyRecipes: [],
      userId: this.$store.state.user.id,
      recipeToSave: {
        checkedRecipes: [],
      },
      showForm: false,
    };
  },
  created() {
    mealService.listRecipesInMeal(this.$route.params.id).then((response) => {
      if (response.status === 200) {
        this.recipes = response.data;
        for (let i = 0; i < this.recipes.length; i++) {
          this.recipesIdsInMeal.push(this.recipes[i].recipeId);
        }
        console.log("RECIPE IDS IN MEAL: " + this.recipesIdsInMeal);
      }
    });
    mealService.getOneMeal(this.$route.params.id).then((response) => {
      if (response.status === 200) {
        this.meal = response.data;
      }
    });
  },
  methods: {
    deleteRecipeFromMeal(recipeId) {
      recipeService
        .deleteRecipeFromMeal(this.$route.params.id, recipeId)
        .then((response) => {
          if (response.status === 200) {
            alert("Recipe deleted from Meal");
            window.location.reload();
          }
        });
    },
    addNewRecipe() {
      console.log(
        "Recipe To Add before for each: " + JSON.stringify(this.recipeToSave)
      );
      this.recipeToSave.checkedRecipes.forEach((recipeId) => {
        mealService
          .addMealWithRecipe(this.$route.params.id, recipeId)
          .then((response) => {
            if (response.status === 200) {
              alert("Recipe have been added!");
            }
          });
      });
    },
    getRecipes() {
      this.userId = this.$store.state.user.id;
      recipeService.getMyRecipes(this.userId).then((response) => {
        for (let i = 0; i < response.data.length; i++) {
          if (!this.recipesIdsInMeal.includes(response.data[i].recipeId)) {
            this.allMyRecipes.push(response.data[i]);
          }
        }
      });
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");

.recipes {
  text-align: left;
  padding-left: 600px;
}
.addNewRecipeForm {
  border: 5px double black;
  margin: 20px;
  padding: 15px;
  margin-right: 100px;
  margin-left: 100px;
  background-color: #e9e8e8;
}
.mealDetailsContainer {
  font-family: Raleway;
  display: flex;
  flex-direction: column;
  /* align-items: center; */
  text-align: center;
  margin-right: 200px;
  margin-left: 200px;
  padding: 1vh;
  margin: 40px;
  box-shadow: 8px 8px 8px rgba(68, 68, 68, 0.6);
  background-color: rgb(148, 148, 148);
}
.mealDetailsContainer .content {
  box-shadow: 0px 10px 10px rgba(68, 68, 68, 0.363);
  position: relative;
  padding: 1vh;
  background-color: #ddd;
  background-image: url("~@/pictures/background1.jpeg");
  background-repeat: no-repeat;
  background-size: cover;
}
.recipeCard {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex: 500px;
  border: 5px double black;
  height: 150px;
  padding: 20px;
  background-color: #e9e8e8;
  margin: 20px;
}
.recipeCardContainer {
  display: flex;
  flex-wrap: wrap;
  margin-right: 100px;
  margin-left: 100px;
}
.deleteRecipeInMeal {
  border: 0.5px solid black;
  font-family: Raleway;
  display: flex;
  font-size: 2vh;
  width: 175px;
  height: 100px;
  text-align: center;
  align-items: center;
  justify-content: center;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
  margin: 25px;
}
.mealName {
  font-family: Raleway;
  font-size: 2.5rem;
}
.addRecipeBtn {
  border: .5px black solid;
  font-family: Raleway;
  display: flex;
  width: 200px;
  height: 50px;
  font-size: 2vh;
  background: #f3f0f1;
  margin-top: 30px;
  margin-bottom: 25px;
  border-radius: 32px;
  margin-left: auto;
  margin-right: auto;
  /* text-align: center; */
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
}

.addBtn {
  border: 0.5px solid black;
  font-family: Raleway;
  font-size: 2vh;
  width: 100px;
  height: 25px;
  text-align: center;
  align-items: center;
  justify-content: center;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
  margin: 25px;
}
</style>