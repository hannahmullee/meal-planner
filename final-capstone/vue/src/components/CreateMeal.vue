<template>
  <div class="newMeal">
    <div class="content">
      <h1>Create New Meal</h1>
    </div>
    <main-nav /><br />
    <br />
    <form class="meal-form">
      <label class="meal-form-element prompt">Name: </label><br />
      <input
        class="meal-name meal-form-element"
        id="meal-name"
        v-model="mealToSave.name"
      />
      <p class="meal-form-element prompt">
        Check the recipes you'd like to add to this meal:
      </p>
      <div
        v-for="recipe in allMyRecipes"
        :key="recipe.recipeId"
        class="meal-checkbox meal-form-element"
      >
        <input
          v-model="mealToSave.checkedItems"
          type="checkbox"
          v-bind:value="recipe.recipeId"
        />
        <label> {{ recipe.title }} </label>
      </div>
      <button
        v-on:click.prevent="
          saveMeal();
          saveMealWithRecipe();
        "
        class="meal-form-element add-meal-button"
      >
        Add Meal
      </button>
    </form>
  </div>
</template>

<script>
import recipeService from "../services/RecipeService";
import mealService from "../services/MealService";
import MainNav from "./MainNav.vue";

export default {
  components: {
    MainNav,
  },
  data() {
    return {
      allMyRecipes: [],
      mealToSave: {
        name: "",
        checkedItems: [],
        userId: this.$store.state.user.id,
      },
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
  methods: {
    saveMeal() {
      console.log("Step One");
      this.mealToSave.userId = this.$store.state.user.id;
      mealService
        .addMeal(this.mealToSave)
        .then((response) => {
          if (response.status === 201) {
            alert("Your meal has been created!");
          }
        })
        .catch((error) => {
          console.error(error + " meal was not saved!");
        });
    },
    getMealId() {},

    saveMealWithRecipe() {
      this.mealToSave.checkedItems.forEach((id) => {
        let recipeId = id;
        // let mealId = this.getMealId();
        console.log(this.mealToSave.name);
        setTimeout(() => {
          mealService.getMealId(this.mealToSave.name).then((response) => {
            if (response.status === 200) {
              console.log("Got Meal ID! " + response.data);
              setTimeout(() => {
                mealService
                  .addMealWithRecipe(response.data, recipeId)
                  .then((response) => {
                    if (response.status === 201) {
                      console.log(
                        "Meal ID and Recipe ID have been added to second table"
                      );
                    
                    }
                  });
              }, 2000);
            }
          });
        }, 2000);
      });
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");

.newMeal {
  text-align: center;
  padding: 1vh;
  margin: 40px;
  box-shadow: 8px 8px 8px rgba(68, 68, 68, 0.6);
  background-color: rgb(148, 148, 148);
}
.newMeal .content {
  box-shadow: 0px 10px 10px rgba(68, 68, 68, 0.363);
  position: relative;
  padding: 1vh;
  background-color: #ddd;
  background-image: url("~@/pictures/background1.jpeg");
  background-repeat: no-repeat;
  background-size: cover;
}

.meal-form {
  font-family: Raleway, Verdana, Geneva, Tahoma, sans-serif;
  border: ridge rgb(114, 123, 128) 2px;
  background-color: #dee2e4;
  padding: 25px;
  width: 500px;
  margin-right: auto;
  margin-left: auto;
}

.prompt {
  font-weight: bolder;
}

.meal-checkbox{
  text-align: left;
  padding-left: 80px;
}

.meal-form-element {
  margin: 10px;
  font-size: 2.5vh;
}

.add-meal-button {
  width: 180px;
  height: 40px;
  font-size: 2.5vh;
  background: #fdfdfd;
  margin-bottom: 25px;
  border-radius: 32px;
  text-align: center;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
  font-family: Raleway;
  border: 0.5px solid black;
}

@media (max-width: 400px) {
  .meal-one,
  .meal-two,
  .meal-three {
    display: block;
  }
}
</style>