<template>
  <div>
    <form v-on:submit.prevent="searchRecipes()">
      <label class="search" for="recipeSearch">Search: </label>
      <input
        class="search-box"
        type="text"
        name="recipeSearch"
        id="recipeSearch"
        v-model="searchTerm"
      />
      <button class="submit">Submit</button>
    </form>
    <br />
    <br />
    <div class="browse">
      <div class="output" v-for="recipe in recipes" v-bind:key="recipe.id">
        <h2>{{ recipe.title }}</h2>
        <img v-bind:src="recipe.image" />
        <br />
        <br />
        <div class="recipeDetails">
          <router-link
            :to="{ name: 'searchRecipeDetails', params: { id: recipe.id } }"
            ><button class="viewRecipeDetailsBtn">View Recipe Details</button></router-link
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import apiService from "../services/ApiService";

export default {
  props: {
    recipeId: Number,
  },
  data() {
    return {
      recipes: [],
      searchTerm: "",
    };
  },
  created() {},
  methods: {
    searchRecipes() {
      apiService.searchRecipes(this.searchTerm).then((response) => {
        if (response.status === 200) {
          this.recipes = response.data.results;
          console.log(response.data.results);
        }
      });
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");


.viewRecipeDetailsBtn{
  border: .5px solid black;
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

.submit {
  font-size: 3vh;
}

.submit:hover{
  cursor: pointer;
}

.search {
  font-size: 3vh;
  font-family: Raleway, Verdana, Geneva, Tahoma, sans-serif;
  font-weight: bold;
}
.search-box {
  font-size: 3vh;
}
.output {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-items: center;
  font-family: Raleway, Verdana, Geneva, Tahoma, sans-serif;
  font-size: 3vh;
  border: double black 8px;
  background-color: #dee2e4;
  padding: 25px;
  margin-bottom: 20px;
  width: 500px;
  margin-right: auto;
  margin-left: auto;
}
.browse {
  display: flex;
  flex-wrap: wrap;
}
</style>