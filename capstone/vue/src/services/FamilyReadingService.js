import axios from 'axios';

export default {

  addBook(book) {
    return axios.post('/addBook', book)
  },
  getBooks() {
    return axios.get('/books/list')
  },
  displayFamily() {
    return axios.get('/family/list/${familyId}')
  },
  addFamily(family) {
    return axios.post('/addFamily', family)
  },

  displayUsers() {
    return axios.get('/displayUsers')
  }


}
