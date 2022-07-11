import { createContext, useReducer } from "react";

export const JwtContext = createContext()

export const jwtReducer =(state, action) => {
    switch (action.type) {
        case 'SET_JWT':
            return {
                jwt: action.payload
            }
        default:
            return state
    }
}

export const JwtContextProvider = ({children}) => {

    const [state, dispatch] = useReducer(jwtReducer, {
        jwt:null
        })

        // dispatch({type:'SET_JWT', payload:''})
    return (
        <JwtContext.Provider value={{...state, dispatch}}>
            {children}
        </JwtContext.Provider>
    )
}  