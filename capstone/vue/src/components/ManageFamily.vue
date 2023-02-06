<template>
  <div class="main mx-auto">
    <div class="family_search">
        <h3 id="addFamilyTag" v-on:click="showForm = !showForm">Add Family Member</h3>
        <div id="familySearchBar" v-show='showForm'>
          <input type="text" id = "search" v-model="searchWord" placeholder="enter username">
            <button btn v-on:click="search">Search</button>
             <button btn v-on:click="clear">Clear</button><br><br>
               <div class="user_list">
                 <li id="userlist" v-for="(user, index) in filterList" v-bind:key="index"><div id="userInList">{{user.username}}</div><div id="userButton">
                   <button btn v-on:click="addFamilyMember"> Add Family Member </button> </div>
                </li>
               </div>
              </div>
        </div>
  </div>

    <!-- <a
      id="showForm"
      href="#"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >
      Add a Family
    </a> -->
    <!-- <register/> -->
    <!-- <form
      id="book-form"
      v-on:submit.prevent="addNewFamily"
      v-if="showForm === true"
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
          v-on:click="resetForm"
        />
      </div>
    </form> -->
  <!-- </div> -->
</template>

<script>
import familyReadingService from "../services/FamilyReadingService";
export default {
  name: "manage-family",

    data() {
    return {
      member: {
        username: "",
        userRole: "",
        userId: "",
      },
      user: {
        username: "",
        familyId: this.familyId
      },
      showForm: false,
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

    familyReadingService.displayUsers().then(response => {
      this.userList = response.data;
    })
  },
  methods: {

    resetForm() {
      this.showForm = false;
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
          this.resetForm();
          this.$router.push("/manageFamily")
          //this is where you can call another API call to retrieve brand new list of books
          //route back to home page
        } else {
          alert("unsuccessful");
        }
      });
    },
    search() {
      return this.filterList = this.userList.filter((user) => {
        return user.username.toLowerCase().includes(this.searchWord.toLowerCase());
      });
    },
    clear() {
      return this.filterList=this.userList;
    },

       addFamilyMember(member) {
        this.$store.commit('SET_FAMILY_ID', this.$route.params.familyId);
        familyReadingService.addFamilyMember(this.$store.state.familyId, member.userId)
    }
  },
};
</script>

<style scoped>
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
</style>