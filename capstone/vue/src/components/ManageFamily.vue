<template>
  <div class="main mx-auto">

  </div>
</template>

<script>
import familyReadingService from '../services/FamilyReadingService'
export default {
name: 'manage-family',
data(){
    return{
        member: {
        username:"",
        userRole:"",
        },
        user: {
        username: "", 
        },
        family: [],
        userList: [],
        filterList: [], 
        searchWord: "",
    }
},
created(){
    familyReadingService.displayFamily().then(response => {
        this.family = response.data;
        console.log("this is where my family is")
    })
},
methods:{
    search(){
        return this.filterList = this.userList.filter((user => {
            return user.username.includes(this.searchWord)
        }))
    }
}
}
</script>

<style>

</style>