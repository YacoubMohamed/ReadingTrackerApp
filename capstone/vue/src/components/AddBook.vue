<template>
  
  <div class="main mx-auto">

  </div>
</template>

<script>
import familyService from '../services/FamilyReadingService'
export default {
    name: "add-book",
    data(){
        return {
            newBook : {
                title: "",
                author: "",
                ISBN: ""
            },
        }
    },
    created() {
        familyService.addBook().then(response =>{
            this.newBook = response.data;
        })
    }


}
</script>

<style>

</style>