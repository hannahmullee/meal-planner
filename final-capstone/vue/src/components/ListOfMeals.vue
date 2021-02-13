<template>
  <div class="allMeals">
    <div class="mealInfo" v-for="meal in allMyMeals" :key="meal.mealId">
      <div class="meal">
        <h3 class="mealName">{{ meal.name }}</h3>

        <router-link
          class="viewRecipesInMeals"
          :to="{ name: 'mealDetails', params: { id: meal.mealId } }"
        >
          <button class="viewRecipesInMealsBtn">View Recipes In Meal</button>
        </router-link>
        <button class ="delete" v-on:click="deleteMeal(meal.mealId)">Delete Meal</button>

      </div>
    </div>
  </div>
</template>

<script>
import mealService from "../services/MealService";

export default {
  data() {
    return {
      allMyMeals: [],
      userId: this.$store.state.user.id,
      recipesInMeal: [],
    };
  },
  created() {
    mealService
      .getMyMeals(this.$store.state.user.id)
      .then((response) => {
        console.log("RESPONSE.DATA: " + JSON.stringify(response.data));
        console.log(JSON.stringify(response.data[0].name));
        this.allMyMeals = response.data;
      })
      .catch((error) => {
        console.error(error + " cannot get my meals");
      });
  },
  methods: {
    deleteMeal(mealId) {
      mealService.deleteMeal(mealId).then((response) => {
        if (response.status === 200) {
          alert("Meal deleted");
          window.location.reload();

        }
      })
      console.log("MEAL ID FROM ALL MY MEALS " + this.allMyMeals[0].mealId);
    }
  },
  
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");

.allMeals {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}

.meal{
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 7px double black;
  margin: 20px;
  width: 500px;
  background-color:#dee2e4;
}

.buttons-my-meals {
  font-family: Raleway;
  font-size: x-large;
}

.viewRecipesInMealsBtn {
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

.edit {
  margin-left: 46%;
  display: flex;
  font-size: 2vh;
  width: 150px;
  height: 50px;
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
.delete {
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

.mealInfo {
  font-family: Raleway;
  font-size: 2.5vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-left: auto;
  margin-right: auto;
}
.row {
  font-weight: bold;
}

</style>