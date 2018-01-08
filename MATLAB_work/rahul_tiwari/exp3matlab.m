clc;
clear all;
close all;

%part-B
%1
n=-1:10;
x=(u(n)-u(n-8));
subplot(3,1,1);
stem(n,x)

h=((sin(2*pi*n./8)).*(x));
subplot(3,1,2);
stem(n,h)

lx=length(x);
lh=length(h);
ly=lx+lh-1;
y=zeros(1,ly);
for i=lh+1:ly
    h(i)=0;
end
for i=lx+1:ly
    x(i)=0;
end

for n=1:ly
    for k=1:lh
       if((n-k)<=0) y(n)=y(n)+(x(k)*h(1));
       else y(n)=y(n)+(x(k)*h(n-k+1));
       end
    end
end

n=-1:21;
%using in-built fuction
z=conv(x,h);
subplot(3,1,3);
stem(n,y)
hold on
n=-1:43;
stem(n,z,'--r')
figure()

% %2
% n=-1:10;
% x=@(n)((0.8).^n).*u(n);
% subplot(3,1,1);
% stem(n,x(n))
% 
% h=@(n)((0.3).^n).*u(n);
% subplot(3,1,2);
% stem(n,h(n))
% figure()
% 
% %3
% n=-1:10;
% x=@(n)(exp(-1*n).*u(n));
% subplot(3,1,1);
% stem(n,x(n))
% 
% h=@(n)((2.^(-1*n)).*u(n));
% subplot(3,1,2);
% stem(n,h(n))