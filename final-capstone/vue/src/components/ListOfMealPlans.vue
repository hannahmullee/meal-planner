<template>
  <div class="listOfMealPlansContainer">
    <div
    class="mealPlanInfo"
     v-for="mealPlan in allMealPlans" 
     :key="mealPlan.mealPlanId"
     >
     <div class="meanPlanContainer">
      <h3>{{ mealPlan.name }}</h3>
        <router-link
          :to="{ name: 'mealPlanDetails', params: { id: mealPlan.mealPlanId } }"
          >
          <button class="viewMealPlanDetails">View Meal Plan Details</button></router-link
        >
      </div>
    </div>
  </div>
</template>

<script>
import mealService from "../services/MealService";

export default {
  data() {
    return {
      allMealPlans: [],
      userId: this.$store.state.user.id,
    };
  },
  created() {
    console.log("This is the user id: " + this.$store.state.user.id);
    mealService
      .getListOfMealPlans(this.$store.state.user.id)
      .then((response) => {
        if (response.status === 200) {
          this.allMealPlans = response.data;
        }
      });
  },
};
</script>

<style>

.viewMealPlanDetails {
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
  margin-left: auto;
  margin-right: auto;
}

.mealPlanInfo{
  margin-left: auto;
  margin-right: auto;
}
.listOfMealPlansContainer {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  
}

.meanPlanContainer {
  justify-content: center;
  align-items: center;
  border: 6px double black;
  width: 300px;
  height: 150px;
  margin-bottom: 25px;
  margin-right: 25px;
  margin-left: 25px;
  background-color: #dee2e4;
}
</style>