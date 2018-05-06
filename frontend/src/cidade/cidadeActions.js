import axios from 'axios'
import { toastr } from 'react-redux-toastr'

const URL = 'http://localhost:3100/api'

export const changeNome = event => ({
    type: 'NOME_CHANGED',
    payload: event.target.value
})

export const changeEstado = event => ({
    type: 'ESTADO_CHANGED',
    payload: event.target.value
})

export const search = () => {
    return (dispatch, getState) => {
        const nome = getState().cidade.nome
        const estado = getState().cidade.estado
     
        const search = `?nome=${nome}&estado=${estado}`       
     
        const request = axios.get(`${URL}/cidades${search}`)
            .then(resp => {
                dispatch({type: 'CIDADE_SEARCHED', payload: resp.data})
                     
                if (resp.data != null) {
                    if (resp.data.length == 0)
                        toastr.error("Nenhum registro localizado!")
                }
            })
    }
}

export const showScore = (cidade) => {
    return dispatch => {
        const id = cidade.id
        const nome = cidade.nome
        const estado = cidade.estado

        const search = `?id=${id}&nome=${nome}&estado=${estado}`

        axios.get(`${URL}/cidades/pontuacao${search}`).then(resp => {
            toastr.success('Alerta', `A pontuação da cidade ${nome} no estado ${estado} é ${resp.data}`)
        }) 
    }
}

export const clear = () => {
    return [{ type: 'CIDADE_CLEAR' }, search()]
}