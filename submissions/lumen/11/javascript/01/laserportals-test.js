describe('Laserportals', function () {
    it('should follow the lasers correctly', function () {
        expect(f('      v  \n         \n> 9 # 9 @\n         \n  #      ')).toEqual(':D');
    });

    it('should follow the lasers correctly', function () {
        expect(f('     v \n> 9#9 @')).toEqual(':/');
    });

    it('should follow the lasers correctly', function () {
        expect(f(' vvvv \n \\\\\\\\\\\n /////\n 1234 \n 4321 \n///// \n\\\\\\\\\\ \n @@@@')).toEqual(':D');
    });

    it('should follow the lasers correctly', function () {
        expect(f('> \\  @\n> \\  @\n> \\  @')).toEqual(':(');
    });
});
