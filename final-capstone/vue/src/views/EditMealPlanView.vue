<template>
  <div>
    <h1>Update Meal Plan</h1>
    <main-nav />
    <edit-meal-plan />
  </div>
</template>

<script>
import EditMealPlan from "../components/EditMealPlan.vue";
import MainNav from "../components/MainNav.vue";

export default {
  components: {
    MainNav,
    EditMealPlan,
  },
};
</script>

<style>


</style>