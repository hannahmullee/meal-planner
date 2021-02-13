<template>
  <div>
<form class="mealPlans">

</form>

    <form class="groceryList">
      <input type="button" value="Print this page" onClick="window.print()" />
      <!-- <button v-on:click="window.print()"> Print this page</button> -->
      <p class="DeleteItemsPrompt">Check the items you would like to remove</p>
      <div
        v-for="ingredient in groceryList"
        v-bind:key="ingredient.ingredientId"
        class="groceryItems"
      >
        <input
          v-model="checkedItemsToDelete"
          type="checkbox"
          v-bind:value="ingredient.ingredientId"
        />
        <label>
          {{ ingredient.quantity }}  {{ ingredient.measurement }} 
          {{ ingredient.name }}
        </label>
      </div>
      <button class="removeBtn" v-on:click.prevent="removeIngredientsFromList()">
        Remove Items
      </button>
    </form>
  </div>
</template>

<script>
import mealService from "../services/MealService";

export default {
  data() {
    return {
      groceryList: [],
      checkedItemsToDelete: [],
    };
  },
  created() {
      mealService.getGroceryList(this.$store.state.mealPlanId).then((response) => {
        this.groceryList.push(response.data[0]);
        for (let i = 1; i < response.data.length; i++) {
          if (
            response.data[i].ingredientId === response.data[i - 1].ingredientId
          ) {
            i++;
          } else {
            this.groceryList.push(response.data[i]);
          }
        }
      });
  },

  methods: {

    removeIngredientsFromList() {
      for (let i = 0; i < this.groceryList.length; i++) {
        if (
          this.checkedItemsToDelete.includes(this.groceryList[i].ingredientId)
        ) {
          this.groceryList.splice(i, i + 1);
        }
      }

  },
}
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");

.groceryList {
  font-family: Raleway, Verdana, Geneva, Tahoma, sans-serif;
  border: 7px double black;
  background-color: #dee2e4;
  padding: 25px;
  width: 500px;
  margin-right: auto;
  margin-left: auto;
}
.DeleteItemsPrompt {
  font-weight: bolder;
  font-size: 2.5vh;
}
.groceryItems {
  text-align: left;
  font-size: 2.5vh;
  margin: 10px;
}
.removeBtn {
  width: 180px;
  height: 40px;
  font-size: 2.5vh;
  background: #fdfdfd;
  margin-top: 25px;
  border-radius: 32px;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
  font-family: Raleway;
  border: .5px solid black;
}
</style>