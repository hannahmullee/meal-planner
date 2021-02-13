<template>
  <div id="app">
    <div id="nav">
      <div class="homeLink">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      </div>
      <div class="logout">
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link>
       </div>
    </div>

    <router-view />
  </div>
</template>
<style>
body {
  /* background-color: rgb(230, 216, 201); */
  /* background-image: linear-gradient(to bottom, rgb(229, 212, 194), rgb(228, 193, 155)); */
  background-image: linear-gradient(
    to bottom,
    rgb(223, 223, 223),
    rgb(179, 179, 179)
  );
  background-attachment: fixed;
  font-family: Arial, Helvetica, sans-serif;
}

#nav {
  /* margin: 50px; */
  display: flex;
  width: 175px;
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

#nav:hover{
  background-color: #ffffff;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
}




</style>
