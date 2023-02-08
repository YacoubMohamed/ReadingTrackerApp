<template>
  <div class="home">
    <div class="div-one">
      <div class="container-one">
        <img src="../assets/logo.jpg" alt="Read" />
      </div>

      <div class="container-two">
        <div class="welcome">
          <h1>Welcome, {{ $store.state.user.username }}!</h1>
          <img id="books" src="../assets/book.webp" alt="" />
        </div>
      </div>
      <div class="container-three">
        <div class="prompt">What would you like to do?</div>

        <ul class="menu-nav">
          <li class="choice">
            <router-link v-bind:to="{ name: 'manageBooks' }">
              Your Books
            </router-link>
          </li>

          <li class="choice">
            <router-link v-bind:to="{ name: 'addBook' }">
              Manage Books
            </router-link>
          </li>

          <li class="choice">
            <router-link v-bind:to="{ name: 'manageFamily' }">
              Manage Family
            </router-link>
          </li>
           <li class="choice">
            <router-link v-bind:to="{ name: 'manageFamily' }">
              Manage Prizes
            </router-link>
          </li>
        </ul>
      </div>
    </div>
    <div class="div-two">
      <div class="number-of-books">
        <p class="infographic">1000 PAGES</p>
      </div>

      <div class="graphics">
        <p class="infographic">HERE IS THE GRAPH</p>
      </div>
            <div class="number-of-books">
        <p class="infographic">3 books til your next goal!</p>
      </div>

      <div class="graphics">
        <p class="infographic">HERE IS THE GRAPH</p>
      </div>

    </div>
   
    <div class="div-three">
       
      <div class="spouse">
        <h3> Family Members </h3>
        <img src="../assets/bookworm.jpg" alt="" />
      </div>
      <div class="child 1">
        <img src="../assets/baby.jpg" alt="" />
      </div>
      <div class="child 2">
        <img src="../assets/funnyboy.jpg" alt="" />
      </div>
    </div>
  </div>
</template>

<script>
//import Register from './Register.vue';
export default {
  //components: { Register },
  name: "home",
};
</script>

<style scoped>

#books {
  margin-left: 3em;
}

.home {
  height: 100%;
  background-color: rgb(241, 238, 238); 
  display: flex;
  flex-basis: 25%;
  flex-direction: row;
  justify-content: space-between;
  box-shadow: inset 0 0 10px rgb(192, 189, 189);
  border-radius: 5px;
}
.div-one {
  height: 100vh;
  display: flex;
  align-content: center;
  flex-direction: column;
  justify-content: top;
  box-shadow: inset 0 0 10px rgb(192, 189, 189);
  
  border-radius: 5px;
  padding: 1em;
}

h1 {
  padding-top: 1em;
  margin-left: .5em;
  color: #035149;
  font-size: 25px;
}

h3 {
  font-family: 'Open Sans', sans-serif;
  font-size: 15px;
  color: #035149;
}

.div-two {
  display: flex;
  flex-grow: 2;
  flex-wrap: wrap;
  justify-content: space-around;
  border-radius: 5px;
  padding: 3em;
}
.infographic {
  display: flex;
  justify-content: center;
  align-items: center;
  border: 0px ;
  border-radius: 20px;
  box-shadow: inset 0 0 15px rgb(160, 158, 158);
  width: 250px;
  height: 200px;
  background-color: #2ab675;
  color: rgb(241, 238, 238);
}
.div-three {
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  padding: 2em;
}

.container-one {
  padding: .5em 2em 0em 1.5em;
  margin-top: 5%;
}
.container-three {
  display: flex;
  flex-direction: column;
  padding-top: 2em;
}


.div-three img {
  height: 8rem;
  border-radius: 50%;
}

.welcome img {
  height: 8rem;
  border-radius: 50%;
}

.prompt {
  font-size: 16px;
  font-weight: bold;
  width: 100%;
}

.choice,
.choice a {
  color: rgb(65, 65, 158);
  font-weight: bold;
  list-style: none;
  text-decoration: none;
  margin-top: 10px;
}
</style>
