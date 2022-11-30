import Vue from 'vue'
import { Modal } from 'bootstrap'

Vue.mixin({
  methods: {
    getBootstrapModal(id) {
      return new Modal(id)
    },
  },
})
