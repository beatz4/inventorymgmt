

class ProductMgmt {

    constructor(config) {

        this.config = {
            grid: config.grid,
            columns: config.columns
        };

        this.grid = this.initGrid();
        // this.loadData();
        // this.addGridEvent();
    }

    initGrid() {

        const grid = new tui.Grid({
            el: document.getElementById(this.config.grid),
            rowHeaders: ['checkbox'],
            scrollX: true,
            scrollY: true,
            draggable: false,
            header: { height: 30 },
            bodyHeight: 200,
            contextMenu: null,
            columns: this.config.columns,
            pageOptions: {
                useClient: true,
                type: 'scroll',
                perPage: 50
            }
        });

        return grid;
    }

    addGridEvent() {

        this.grid.on('dblclick', () => {
        });
    }


}