<template>

    <div class="column is-12 conteudo">
        <router-view> </router-view>
    </div>
  
</template>

<style lang="scss">
  @import "~bulma/bulma.sass";

  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
  }

  nav {
    padding: 30px;

    a {
      font-weight: bold;
      color: #2c3e50;

      &.router-link-exact-active {
        color: #42b983;
      }
    }
  }

  .conteudo {
    padding: 100px;
  }

</style>
