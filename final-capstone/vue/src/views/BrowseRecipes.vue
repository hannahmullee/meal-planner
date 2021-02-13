<template>
  <div class="browse-recipes">
    <div class="content">
    <h1>Browse Recipes</h1>
    </div>
    <main-nav />
    <br />
    <search-recipes />
  </div>
</template>

<script>
import SearchRecipes from '../components/SearchRecipes.vue';
import MainNav from "../components/MainNav.vue";

export default {
  components: { MainNav, SearchRecipes },
};
</script>

<style>
.browse-recipes{
  text-align: center;
    padding: 1vh;
  margin: 40px;
  box-shadow: 8px 8px 8px rgba(68, 68, 68, 0.6);
  background-color: rgb(148, 148, 148);
}

.browse-recipes .content {
  box-shadow: 0px 10px 10px rgba(68, 68, 68, 0.363);
  position: relative;
  padding: 1vh;
  background-color: #ddd;
  background-image: url("~@/pictures/background1.jpeg");
  background-repeat: no-repeat;
  background-size: cover;
}
</style>