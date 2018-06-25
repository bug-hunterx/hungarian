describe('Super Mario', function () {
    it('should reach the correct ending', function () {
        expect(f('piranha Princess piranha')).toEqual('WIN');
    });

    it('should reach the correct ending', function () {
        expect(f('1Up koopa goomba piranha Bowser')).toEqual('WIN');
    });

    it('should reach the correct ending', function () {
        expect(f('Star Mushroom  piranha goomba piranha goomba Princess')).toEqual('WIN');
    });

    it('should reach the correct ending', function () {
        expect(f(' piranha piranha piranha piranha`')).toEqual('GAME OVER');
    });

    it('should reach the correct ending', function () {
        expect(f('piranha piranha Star goomba goomba Princess')).toEqual('WIN');
    });

    it('should reach the correct ending', function () {
        expect(f('10 40 koopa goomba 20 30 piranha piranha')).toEqual('GAME OVER');
    });
});
