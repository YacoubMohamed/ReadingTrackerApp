<template>
<div class="main">
  <div class="books">
      <h1> Title: {{ book.title }}</h1>
      <h2> Author: {{ book.author }}</h2>
      <p> ISBN: {{ book.isbn }}</p>
  </div>
  </div>
</template>

<script>
export default {
name: "book-display",
props: ["book"],
}
</script>

<style>

.books {
  background-color: rgb(233, 220, 220);
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  border: 1px black solid;
  border-radius: 6px;
  padding: .001rem;
  margin: 1rem;
}
</style>