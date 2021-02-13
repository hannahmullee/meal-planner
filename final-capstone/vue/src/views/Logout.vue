<template>
<div class="logout">
  <h1>Logout</h1>
</div>
</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  }
};
</script>
<style>

</style>
