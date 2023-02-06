<template>
   <div class="main-mx-auto">
     <div class="cont">
<div class="cont1">
    <a
      id="showForm"
      href="#"
      v-if="showForm1 === false"
      v-on:click.prevent="showForm1 = true"
    >
    <h3>
      Add a Family
      </h3>
    </a>
    <register />
    <form
      id="book-form"
      v-on:submit.prevent="addNewFamily"
      v-if="showForm1 === true"
    >
      <div class="form-element">
        <label for="fm">Family Name: </label>
        <input id="fm" type="text" v-model="family.family_name" />
      </div>
      <div id="button-row">
        <input id="buttons" type="submit" value="Save" />
        <input
          id="buttons"
          type="button"
          value="Cancel"
          v-on:click="resetForm1"
        />
      </div>
    </form>
    </div>

   
<div class="cont2">

        <a href="#" v-on:click.prevent="showForm2 = !showForm2"
          ><h3>Add Family Members</h3></a
        >
        <div id="familySearchBar" v-show="showForm2">
          <input
            type="text"
            id="search"
            v-model="searchWord"
            placeholder="enter username"
          />
          <button btn v-on:click.prevent="search">Search</button>
          <button btn v-on:click="resetForm2">Clear</button><br /><br />
          <div class="user_list">
            <li
              id="userlist"
              v-for="(user, index) in filterList"
              v-bind:key="index"
            >
              <div id="userInList">{{ user.username }}</div>
              <div id="userButton">
                <button btn v-on:click="addFamilyMember(user)">
                  Add Family Member
                </button>
              </div>
            </li>
          </div>
        </div>
      
      </div>
      </div>
<div class="cont3">
      <user-display class="user_list"
        v-for="user in userList"
        v-bind:key="user.id"
        v-bind:user="user"
      />
</div>
    </div>
  
</template>

<script>
import familyReadingService from "../services/FamilyReadingService";
import UserDisplay from "./UserDisplay.vue";
export default {
  components: { UserDisplay },
  name: "manage-family",
  data() {
    return {
      member: {
        username: "",
        userRole: "",
        userId: "",
      },
      familyMembers: [],
      user: {
        username: "",
        familyId: this.familyId,
      },
      showForm1: false,
      showForm2: false,
      family: {
        family_name: "",
      },
      userList: [],
      filterList: [],
      searchWord: "",
    };
  },
  created() {
    familyReadingService.displayFamily().then((response) => {
      this.userList = response.data;
      console.log("this is where my family is");
    });

    familyReadingService.displayUsers().then((response) => {
      console.log(response.data);
      this.userList = response.data;
    });
  },
  methods: {
    resetForm1() {
      this.showForm1= false;
      this.family = {
        family_name: "",
      };
    },
    resetForm2() {
      this.showForm2 = false;
      this.family = {
        family_name: "",
      };
    },
    addNewFamily() {
      familyReadingService.addFamily(this.family).then((response) => {
        if (response.status == 200) {
          alert("Success");
          this.family = response.data;
          this.$store.commit("ADD_FAMILY", this.family);
          this.resetForm2();
          this.$router.push("/manageFamily");
          //this is where you can call another API call to retrieve brand new list of books
          //route back to home page
        } else {
          alert("unsuccessful");
        }
      });
    },
    search() {
      return (this.filterList = this.userList.filter((user) => {
        return user.username
          .toLowerCase()
          .includes(this.searchWord.toLowerCase());
      }));
    },
    clear() {
      return (this.filterList = this.userList);
    },
    addFamilyMember(user) {
      console.log(this.$store.state.familyId);
      console.log("SET FAMILY ID - RUNS NOW");
      //this.$store.commit('SET_FAMILY_ID', this.$route.params.familyId);
      console.log(this.$store.state.familyId);
      familyReadingService.addUserToFamily(this.$store.state.familyId, user);
    },
  },
};
</script>

<style scoped>
.main-mx-auto{
display: flex;
flex-direction: row;
justify-content:space-between;
background-color: lightcoral;
}
.cont{
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}
.form-element {
  padding-left: 4em;
}
#showForm {
  text-decoration: none;
  padding-left: 2em;
}
#buttons {
  margin-right: 10px;
}
#button-row {
  padding-left: 8em;
}
a {
  text-decoration:none ;
  color: black;

}

</style>