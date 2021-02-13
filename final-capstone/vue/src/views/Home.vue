<template>
  <div class="home">
    <div class="content">
      <h1>Home</h1>
    </div>
    <br />
    <main-nav />
    <div class="homepics">
      <div class="pics">
      </div>
    </div>
  </div>
</template>

<script>
import MainNav from "../components/MainNav.vue";

export default {
  data() {
    return {};
  },
  components: { MainNav },
  name: "home",
};
</script>
<style>
.home {
  text-align: center;
  padding: 1vh;
  margin: 40px;
  box-shadow: 8px 8px 8px rgba(68, 68, 68, 0.6);
  background-color: rgb(148, 148, 148);
}

.home .content {
  box-shadow: 0px 10px 10px rgba(68, 68, 68, 0.363);
  position: relative;
  padding: 1vh;
  background-color: #ddd;
  background-image: url("~@/pictures/background1.jpeg");
  background-repeat: no-repeat;
  background-size: cover;

  /* background-image: 'url(' + require('../pictures/background.jpeg') + ')'; */
}
.homepics {
  display: flex;
  flex-direction: row;
}

.pics {
  font-family: Raleway, Verdana, Geneva, Tahoma, sans-serif;
  font-size: 3vh;
  border: ridge rgba(114, 123, 128, 0.644) 6px;
  background-image: url("~@/pictures/avocado.gif"), url("~@/pictures/banana.gif"), url("~@/pictures/brocolli.gif");
  background-position: left , center, right;
  background-repeat: no-repeat, no-repeat, no-repeat;
  background-size: 300px;
  background-color: #dee2e4;
  width: 900px;
  height: 300px;
  margin-right: auto;
  margin-left: auto;
  margin-bottom: 50px;
  margin-top: 50px;
}
</style>