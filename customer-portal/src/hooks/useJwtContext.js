import { JwtContext } from "../context/JwtContext";
import { useContext } from "react";

export const useJwtContext = () => {
    const context = useContext(JwtContext)

    if(!context) {
        throw Error('useJwtContext must be used inside an JwtContextProvider')
    }

    return context
}   