<template>
  <div class="recipe-details">
    <div class="content">
      <h1>Recipe Details</h1>
    </div>
    <main-nav />
    <div class="recipeStuff">
      <h3 class="recipeName">{{ recipe.title }}</h3>
      <p
        class="ingredients"
        v-for="ingredient in ingredients"
        v-bind:key="ingredient.ingredientId"
      >
        {{ ingredient.quantity }} - {{ ingredient.measurement }} -
        {{ ingredient.name }}
      </p>
      <p class="instructions" id="recipe-instructions">
        {{ recipe.instructions }}
      </p>
      <button
        class="edit-btn"
        v-if="showForm === false"
        v-on:click.prevent="showForm = true"
      >
        Edit
      </button>
      <form v-if="showForm === true">
        <div>
          <label for="name">Name: </label>
          <input
            type="text"
            placeholder="Enter new name"
            v-model="recipe.title"
          />
        </div>
        <div>
          <label for="instructions"> Instructions: </label>
          <textarea
            id="instructions"
            v-model="recipe.instructions"
            rows="8"
            cols="40"
          ></textarea>
        </div>
        <input type="submit" value="Save" v-on:click="updateRecipe" />
        <input type="button" value="Cancel" v-on:click.prevent="resetForm" />
      </form>
      <br />
      <button class="delete-btn" v-on:click="deleteRecipe">
        Delete Recipe
      </button>
    </div>
  </div>
</template>

<script>
import RecipeService from "../services/RecipeService";
import mealService from "../services/MealService";
import MainNav from "./MainNav.vue";

export default {
  components: { MainNav },
  props: {
    recipeId: Number,
  },

  data() {
    return {
      recipe: {},
      showForm: false,
      mealIds: [],
      ingredients: [],
    };
  },
  created() {
    console.log("RECIPE ID" + " " + this.$route.params.id);
    RecipeService.getOneRecipe(this.$route.params.id).then((response) => {
      this.recipe = response.data;
      document.getElementById(
        "recipe-instructions"
      ).innerHTML = this.recipe.instructions;
    });

    RecipeService.getIngredients(this.$route.params.id).then((response) => {
      console.log(response.data[0].name);

      for (let i = 0; i < response.data.length; i++) {
        let ingredient = {};
        ingredient.name = response.data[i].name;
        ingredient.ingredientId = response.data[i].ingredientId;
        ingredient.quantity = response.data[i].quantity;
        ingredient.measurement = response.data[i].measurement;
        this.ingredients.push(ingredient);
      }
    });
  },
  methods: {
    updateRecipe() {
      console.log("update recipe");
      const newRecipe = {
        userId: this.$store.state.user.id,
        recipeId: this.$route.params.id,
        title: this.recipe.title,
        instructions: this.recipe.instructions,
      };
      console.log(newRecipe.id);
      RecipeService.editRecipe(newRecipe)
        .then((response) => {
          if (response.status === 202) {
            alert("Recipe has been updated!");
          }
        })
        .catch((error) => {
          console.error(error + " problem updating recipe.");
        });
    },
    resetForm() {
      this.showForm = false;
      this.newRecipe = {};
    },
    deleteRecipe() {
      mealService
        .getMealIdFromRecipeId(this.$route.params.id)
        .then((response) => {
          if (response.status === 200) {
            for (let i = 0; i < response.data.length; i++) {
              this.mealIds.push(response.data[i].mealId);
            }
            console.log("Meal ID array: " + this.mealIds);

            if (this.mealIds.length > 0) {
              console.log(
                "Right before for loop. MealId's array length: " +
                  this.mealIds.length
              );
              for (let j = 0; j < this.mealIds.length; j++) {
                console.log("In the for loop: " + this.mealIds[j]);
                RecipeService.deleteRecipeFromMeal(
                  this.mealIds[j],
                  this.$route.params.id
                ).then((response) => {
                  if (response.status === 200) {
                    console.log("Recipes deleted from meals!");
                    RecipeService.deleteIngredientsFromRecipe(
                      this.$route.params.id
                    ).then((response) => {
                      if (response.status === 200) {
                        console.log(
                          "Ingredients deleted from ingredients table."
                        );

                        RecipeService.deleteRecipe(this.$route.params.id)
                          .then((response) => {
                            if (response.status === 200) {
                              alert("This recipe has been deleted.");
                              this.$router.push("/myRecipes");
                            }
                          })
                          .catch((error) => {
                            console.error(
                              error + " not able to delete recipe."
                            );
                          });
                      }
                    });
                  }
                });
              }
            } else if (this.mealIds.length === 0) {
              RecipeService.deleteIngredientsFromRecipe(
                this.$route.params.id
              ).then((response) => {
                if (response.status === 200) {
                  RecipeService.deleteRecipe(this.$route.params.id)
                    .then((response) => {
                      if (response.status === 200) {
                        alert("This recipe has been deleted.");
                        this.$router.push("/myRecipes");
                      }
                    })
                    .catch((error) => {
                      console.error(error + " not able to delete recipe.");
                    });
                }
              });
            }
          }
        });
    },
  },
};
</script>

<style>

.ingredients{
  margin: 1px;
}

.recipe-details {
  text-align: center;
  padding: 1vh;
  margin: 40px;
  box-shadow: 8px 8px 8px rgba(68, 68, 68, 0.6);
  background-color: rgb(148, 148, 148);
}

.recipe-details .content {
  box-shadow: 0px 10px 10px rgba(68, 68, 68, 0.363);
  position: relative;
  padding: 1vh;
  background-color: #ddd;
  background-image: url("~@/pictures/background1.jpeg");
  background-repeat: no-repeat;
  background-size: cover;
}

.recipeStuff {
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

.edit-btn {
  border: black solid .5px;
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

.delete-btn {
  border: black solid .5px;
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

#recipe-instructions {
  font-size: 2vh;
}
</style>