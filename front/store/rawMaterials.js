// States
export const state = () => ({
  rawMaterials: [],
  rawMaterial: {
    id: '',
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
}

// Actions
export const actions = {
  // Database Operations
  async getRawMaterials({ state, commit }) {
    const response = await this.$axios.$get(
      'http://localhost:8080/api/raw-materials/'
    )
    commit('setRawMaterials', response)
  },

  async postRawMaterial({ state, commit }) {
    if (
      state.rawMaterial.name !== '' &&
      state.rawMaterial.description !== '' &&
      state.rawMaterial.unit !== '' &&
      state.rawMaterial.unit !== '0'
    ) {
      await this.$axios.$post(
        'http://localhost:8080/api/raw-materials/insert',
        state.rawMaterial
      )
    } else await alert('Dados inválidos')
  },

  async deleteRawMaterial({ state, commit }, data) {
    const isDeleted = await this.$axios.$delete(
      `http://localhost:8080/api/raw-materials/delete?_id=${data.rawMaterial._id}`
    )
    isDeleted
      ? commit('deleteRawMaterial', data.position)
      : alert('Erro ao apagar dado')
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
