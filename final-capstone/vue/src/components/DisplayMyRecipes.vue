<template>
  <div class="allRecipies">
    <div
      class="recipeInfo"
      v-for="recipe in allMyRecipes"
      :key="recipe.recipeId"
    >
      <div class="infoContainer">
        <h3 class="recipeName">{{ recipe.title }}</h3>
        <router-link
          :to="{ name: 'recipeDetails', params: { id: recipe.recipeId } }"
        >
          <button class="viewRecipesBtn">View Recipe Details</button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import recipeService from "../services/RecipeService";

export default {
  data() {
    return {
      allMyRecipes: [],
      userId: this.$store.state.user.id,
    };
  },
  created() {
    recipeService
      .getMyRecipes(this.userId)
      .then((response) => {
        this.allMyRecipes = response.data;
      })
      .catch((error) => {
        console.error(error + " cannot get my recipes");
      });
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");

.recipeInfo{
  margin-left: auto;
  margin-right: auto;
}

.recipeName {
  font-family: Raleway;
  font-size: x-large;
}
.allRecipies {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}
.infoContainer {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 6px double black;
  width: 500px;
  height: 250px;
  margin-bottom: 25px;
  margin-right: 25px;
  margin-left: 25px;
  background-color: #dee2e4;
  /* margin-left: auto;
  margin-right: auto; */
}

.viewRecipesBtn {
  border: 0.5px solid black;
  font-family: Raleway;
  display: flex;
  font-size: 2vh;
  width: 175px;
  height: 60px;
  text-align: center;
  align-items: center;
  justify-content: center;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
}
</style>