const INITIAL_STATE = { nome: '', estado: '', list: [] }

export default (state = INITIAL_STATE, action) => {
    switch(action.type) {
        case 'NOME_CHANGED':
            return { ...state, nome: action.payload }
        case 'ESTADO_CHANGED':
            return { ...state, estado: action.payload }            
        case 'CIDADE_SEARCHED':
            return { ...state, list: action.payload }
        case 'PONTUACAO_SEARCHED':
            //return { ...state, list: action.payload }            
            return null
        case 'CIDADE_CLEAR':
            return { ...state, estado: '', nome: ''}
        default:
            return state
    }
}