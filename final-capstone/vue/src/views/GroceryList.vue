<template>
<div class="grocery-list">
  <div class="content">
  <h1>Grocery List</h1>
  </div>
  <main-nav />
  <view-grocery-list />
</div>
</template>

<script>
import MainNav from '../components/MainNav.vue';
import ViewGroceryList from '../components/ViewGroceryList.vue';

export default {
  components: { MainNav, ViewGroceryList },

}
</script>

<style>
.grocery-list{
  text-align: center;
  padding: 1vh;
  margin: 40px;
  box-shadow: 8px 8px 8px rgba(68, 68, 68, 0.6);
  background-color: rgb(148, 148, 148);
}
.grocery-list .content {
  box-shadow: 0px 10px 10px rgba(68, 68, 68, 0.363);
  position: relative;
  padding: 1vh;
  background-color: #ddd;
  background-image: url("~@/pictures/background1.jpeg");
  background-repeat: no-repeat;
  background-size: cover;
}
</style>