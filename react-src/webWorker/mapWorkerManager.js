const workerRegistry = new Map();

export const getWorkerForSku = (sku) => {
    if (!workerRegistry.has(sku)) {
        const worker = new Worker(new URL('../webWorker/webWorkerThread.js', import.meta.url), {
            type: 'module'
        });
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
