<template>
  <div class="create-meal-plan">
    <div class="content">
    <h1>Create A New Meal Plan</h1>
    </div>
    <main-nav />
    <add-new-meal-plan />
  </div>
</template>

<script>
import AddNewMealPlan from "../components/AddNewMealPlan";
import MainNav from '../components/MainNav.vue';

export default {
  components: { AddNewMealPlan,
  MainNav },
};
</script>

<style>
.create-meal-plan{
text-align: center;
align-items: center;
 padding: 1vh;
  margin: 40px;
  box-shadow: 8px 8px 8px rgba(68, 68, 68, 0.6);
  background-color: rgb(148, 148, 148);

}
.create-meal-plan .content {
  box-shadow: 0px 10px 10px rgba(68, 68, 68, 0.363);
  position: relative;
  padding: 1vh;
  background-color: #ddd;
  background-image: url("~@/pictures/background1.jpeg");
  background-repeat: no-repeat;
  background-size: cover;
}


</style>