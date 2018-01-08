function y = correlation(x,h)
    xlen = length(x);
    hlen = length(h);
    x=x';
    mul = x*h;
    res = zeros(xlen+hlen-1,1);
    for i = 1:xlen
        for j = 1:hlen  
            res(i+j-1) = res(i+j-1)+mul(i,hlen-j+1);
      
         end
    end
    y = res ;
end