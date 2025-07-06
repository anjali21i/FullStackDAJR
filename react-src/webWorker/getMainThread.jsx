import { createWebWorker } from "./workerFactory";

export const getMainThreadMsg = ({ data }) => {

    useEffect(() => {

        if (!data && !isNotEmpty(data)) return;

        const worker = createWebWorker(scoreWebworker);

        worker.postMessage({ type: 'INIT' });

        const handleWorkerMessage = (e) => {
            const { type, data, error, payload } = e.data;
            switch (type) {
                case 'READY': {
                    self.postMessage({ type: "FETCH_DATA" });
                    break;
                }
                case 'GET_DATA':
                    if (data) {
                        console.log('Data received from worker:', data);
                        worker.postMessage({ type: 'DONE', data });
                    } else {
                        console.warn('No data received from worker');
                        worker.postMessage({ type: 'RETRY' });
                    }
                    break;
                case 'DONE':
                    if (data) {
                       console.log('Worker finished with data:', data);                        
                    } else {
                        console.warn('Worker finished without data:', error);
                    }
                    break;
                case 'NO_DATA':
                case 'ERROR':
                    console.warn('Worker ended with error:', error);
                    break;
                default:
                    console.warn("Unhandled worker message:", type);
                    break;
            }
        };
        worker.addEventListener("message", handleWorkerMessage);
        return () => {  //eslint-disable-line
            worker.removeEventListener("message", handleWorkerMessage);
            worker.terminate();
        };
    }, [acus?.acus_id, childSku, mode, displayType, dispatch, jwt, userData]); //eslint-disable-line
}