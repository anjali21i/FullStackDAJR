import { createWebWorkerByMeta } from "./workerFactory";

const workerRegistry = new Map();

export const getWorkerForSku = (sku) => {
    if (!workerRegistry.has(sku)) {
        const worker = createWebWorkerByMeta('../webWorker/webWorkerThread.js');
        workerRegistry.set(sku, worker);
    }
    return workerRegistry.get(sku);
};

export const terminateWorkerForSku = (sku) => {
    const worker = workerRegistry.get(sku);
    if (worker) {
        worker.terminate();
        workerRegistry.delete(sku);
    }
};
