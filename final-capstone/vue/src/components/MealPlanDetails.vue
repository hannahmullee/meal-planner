<template>
  <div class="mealPlanDetails">
    <div class="content">
      <h1 class="mealPlanDetailTitle">Meal Plan Details</h1>
    </div>
    <main-nav />
    <div class="mealPlanTableContainer">
      <table class="mealPlanTable">
        <thead>
          <tr>
            <th colspan="8" class="mealPlanTableTitleHeader">
              <h2 class="mealPlanTableTitle">{{ oneMealPlan.name }}</h2>
            </th>
          </tr>
          <tr>
            <th class="tableHeaders"></th>
            <th class="tableHeaders">Monday</th>
            <th class="tableHeaders">Tuesday</th>
            <th class="tableHeaders">Wednesday</th>
            <th class="tableHeaders">Thursday</th>
            <th class="tableHeaders">Friday</th>
            <th class="tableHeaders">Saturday</th>
            <th class="tableHeaders">Sunday</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th class="timeOfDay">Breakfast</th>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[0].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[3].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[6].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[9].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[12].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[15].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[18].mealName }}
            </td>
          </tr>
          <tr>
            <th class="timeOfDay">Lunch</th>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[1].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[4].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[7].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[10].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[13].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[16].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[19].mealName }}
            </td>
          </tr>
          <tr>
            <th class="timeOfDay">Dinner</th>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[2].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[5].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[8].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[11].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[14].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[17].mealName }}
            </td>
            <td class="mealPlanTableContents">
              {{ this.mealPlan[20].mealName }}
            </td>
          </tr>
        </tbody>
      </table>
      <div class="add-ingredients"> 
        <button class="addIngredients-btn" v-on:click="addToGroceryList()">
            Add Ingredients To Grocery List
          </button>
      </div>
      <!-- <div>
        <button class="edit-btn">
          <router-link
            :to="{
              name: 'editMealPlan',
              params: { id: this.mealPlan[0].mealPlanId },
            }"
            >Edit</router-link
          >
        </button>
      </div> -->
    </div>
  </div>
</template>

<script>
import MealService from "../services/MealService";
import MainNav from "./MainNav.vue";

export default {
  components: { MainNav },
  data() {
    return {
      mealPlan: [],
      meal: {},
      meals: [],
      oneMealPlan: {},
    };
  },
  created() {
    MealService.getSchedule(this.$route.params.id).then((response) => {
      this.mealPlan = response.data;
      console.log(this.mealPlan);
    });
    MealService.getMealPlan(this.$route.params.id).then((response) => {
      if (response.status === 200) {
        this.oneMealPlan = response.data;
      }
    });
  },
  methods: {
    addToGroceryList() {
      this.$store.commit("SAVEMEALPLANID", this.$route.params.id);
      alert("Ingredients added!");
    },
    // addToGroceryList() {
    //         MealService.getGroceryList(this.$route.params.id).then((response) => {
    //     this.groceryList.push(response.data[0]);
    //     for (let i = 1; i < response.data.length; i++) {
    //       if (
    //         response.data[i].ingredientId === response.data[i - 1].ingredientId
    //       ) {
    //         i++;
    //       } else {
    //         this.groceryList.push(response.data[i]);
    //       }
    //     }
    //     this.$store.commit("SAVEGROCERYLIST", this.groceryList);
    //   });
    // }
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");

.add-ingredients {
  margin-top: 20px;
  border: solid black 0.5px;
}
.mealPlanDetails {
  box-shadow: 8px 8px 8px rgba(68, 68, 68, 0.6);
  background-color: rgb(148, 148, 148);
  padding: 3vh;
  margin: 40px;
}
.mealPlanDetailTitle {
  text-align: center;
}

.mealPlanTableTitleHeader {
  border-bottom: 1px solid black;
}

.mealPlanTable {
  font-family: Raleway;
  border: 1.5px black solid;
  padding: 10px 30px 30px 30px;
  background-color: #dee2e4;
}

.mealPlanTableContainer {
  margin-left: 250px;
  margin-right: 250px;
  display: flex;
  flex-direction: column;
}

.tableHeaders {
  padding-bottom: 10px;
  border-bottom: 1px black solid;
}

.mealPlanTableContents {
  width: 250px;
  height: 50px;
  text-align: center;
  padding: 5px;
  word-wrap: break-word;
}

.mealPlanDetails .content {
  box-shadow: 0px 10px 10px rgba(68, 68, 68, 0.363);
  position: relative;
  padding: 1vh;
  background-color: #ddd;
  background-image: url("~@/pictures/background1.jpeg");
  background-repeat: no-repeat;
  background-size: cover;
}

.addIngredients-btn {
  font-weight: bold;
  font-family: Raleway;
  
}

.edit-btn {
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
}
</style>