library ieee;
use ieee.std_logic_1164.all;

entity NOR_ent is
  port ( x : in std_logic;
  y : in std_logic;
  f : out std_logic);
end NOR_ent;

architecture NOR_arch of NOR_ent is
begin
  process (x, y)
  begin
    if ((x = '0') and (y = '0')) then
      f <= '1';
    else
      f <= '0';
    end if;
  end process;
end NOR_arch;

