describe('Order by frequency', function () {
    it('should return the good values Hello World', function () {
        expect(f('Hello, World!')).toEqual(' !,HWderoolll');
    });

    it('should return the good value to Results, Relentlessly', function () {
        expect(f('Results, Relentlessly')).toEqual(' ,nuyRRtteeeellllssss');
    });
});
