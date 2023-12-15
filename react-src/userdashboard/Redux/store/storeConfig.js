import { configureStore } from "@reduxjs/toolkit";
import { FLUSH, PAUSE, PERSIST, PURGE, REGISTER, REHYDRATE } from "redux-persist";
import persistStore from "redux-persist/lib/persistStore";

export const getStoreConfig = (initialState) => {

    let storeConfig = {
        reducer: persistedReducer,
        preloadedState: initialState,
        devTools: process.env.REACT_APP_ENVIRONMENT !== "production",
        middleware: (getDefaultMiddleware) =>
            getDefaultMiddleware({
                serializableCheck: {
                    ignoredActions: [FLUSH, REHYDRATE, PAUSE, PERSIST, PURGE, REGISTER]
                }
            })
    };
    return storeConfig;
};
export const clientStore = configureStore(getStoreConfig());

export const persistor = persistStore(clientStore);
