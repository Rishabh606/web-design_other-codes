clc
clear all
close all
x= -100:1:100;
y(201)=0;
for i=1:201
    if x(i)<0
        y(i)=-1;
    elseif x(i)>0
            y(i)=1;
    else
        y(i)=0;
    end
end
plot(x,y)
    