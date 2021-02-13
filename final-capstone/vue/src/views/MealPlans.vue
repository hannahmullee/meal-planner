<template>
  <div class="meal-plans">
    <div class="content">
      <h1>My Meal Plans</h1>
    </div>
      <main-nav />
      <list-of-meal-plans />
  </div>
</template>

<script>
import ListOfMealPlans from '../components/ListOfMealPlans.vue'
import MainNav from '../components/MainNav.vue'

export default {
components: {
  MainNav,
ListOfMealPlans
}
}
</script>

<style
MainNav>
.meal-plans{
  text-align: center;
  padding: 1vh;
  margin: 40px;
  box-shadow: 8px 8px 8px rgba(68, 68, 68, 0.6);
  background-color: rgb(148, 148, 148);
}
.meal-plans .content {
  box-shadow: 0px 10px 10px rgba(68, 68, 68, 0.363);
  position: relative;
  padding: 1vh;
  background-color: #ddd;
  background-image: url("~@/pictures/background1.jpeg");
  background-repeat: no-repeat;
  background-size: cover;
}
</style>