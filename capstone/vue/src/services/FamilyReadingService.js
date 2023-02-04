import axios from 'axios';

export default {

  addBook(book) {
    return axios.post('/book', book)
  },
  getBooks() {
    return axios.get('/book/list')
  },
  // displayFamily() {
  //   return axios.get('/family/list/${familyId}')
  // },
  addFamily(family) {
    return axios.post('/addFamily', family)
  },


}
