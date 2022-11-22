// States
export const state = () => ({
  rawMaterials: [],
  rawMaterial: {
    _id: '',
    name: '',
    description: '',
    unit: '',
  },
})

// Mutations
export const mutations = {
  setRawMaterials(state, value) {
    state.rawMaterials = value
  },

  pushRawMaterial(state, value) {
    state.rawMaterials.push(value)
  },

  setRawMaterial(state, value) {
    state.rawMaterial = value
  },

  setName(state, value) {
    state.rawMaterial.name = value
  },

  setDescription(state, value) {
    state.rawMaterial.description = value
  },

  setUnit(state, value) {
    state.rawMaterial.unit = value
  },

  deleteRawMaterial(state, position) {
    state.rawMaterials.splice(position, 1)
  },

  clearId(state) {
    state.rawMaterial._id = null
  },
}

// Actions
export const actions = {
  // Database Operations
  async getRawMaterials({ state, commit }) {
    if (state.rawMaterials.length === 0) {
      const response = await this.$axios.$get(
        'http://localhost:8080/api/raw-materials/'
      )
      commit('setRawMaterials', response)
    }
  },

  async postRawMaterial({ state, commit }) {
    await this.$axios.$post(
      'http://localhost:8080/api/raw-materials/insert',
      state.rawMaterial
    )

    commit('pushRawMaterial', state.rawMaterial)
  },

  async deleteRawMaterial({ state, commit }, data) {
    await this.$axios.$delete(
      `http://localhost:8080/api/raw-materials/${data.rawMaterial._id}`
    )

    commit('deleteRawMaterial', data.position)
  },

  setRawMaterial({ state, commit }, value) {
    commit('setRawMaterial', value)
  },

  setName({ state, commit }, value) {
    commit('setName', value)
  },

  setDescription({ state, commit }, value) {
    commit('setDescription', value)
  },

  setUnit({ state, commit }, value) {
    commit('setUnit', value)
  },

  //   async deleteRawMaterial({ state, commit }, data) {
  //     const isDeleted = await this.$axios.$delete(
  //       `http://localhost:8080/api/units/delete?_id=${data.rawMaterial._id}`
  //     )
  //     isDeleted
  //       ? commit('deleteRawMaterial', data.position)
  //       : alert('Erro ao apagar dado')
  //   },

  // Store operations
  //   setRawMaterials({ state, commit }, rawMaterials) {
  //     commit('setRawMaterials', rawMaterials)
  //   },

  //   setRawMaterial({ state, commit }, rawMaterial) {
  //     commit('setRawMaterial', rawMaterial)
  //   },

  //   setName({ state, commit }, name) {
  //     commit('setName', name)
  //   },
  //   setDescription({ state, commit }, description) {
  //     commit('setDescription', description)
  //   },
}
